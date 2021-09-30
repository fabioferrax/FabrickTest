# FabrickTest
Appicazione di Test integrata con le API SANDBOX di fabrick

L'applicazione è stata sviluppata a scopo di test.
Racchiude 3 API REST per l'integrazione dei servizi esposti dalla piattaforma Fabrick Developer.

Strutturata sulla base dei modelli MVC, l'applicazione è stratificata come segue:
```java
		  _________	   _________     ________ 
		  |    C   |      |        |    |        |
		  |    O   |      |    S   |    |        |
		  |    N   |      |    E   |<-->|  DAO   | <--->(DB)
		  |    T   |      |    R   |    |        |
		  |    R   |      |    V   |    |________|
JSON In/Out <---> |    O   |<---> |    I   |     _________
		  |    L   |      |    S   |    |        |
		  |    L   |      |    E   |    |Fabrick |
		  |    E   |      |    S   |<-->|   API  | 
		  |    R   |      |        |    |        |
		  |________|      |________|    |        |
                                           	|________|
```										   
													                                                         
L'applicazione è stata costruita sfruttando il framework Spring-boot per la realizzazione e l'esposizione delle API REST.

# HOW TO RUN

L'applicazione decessita di una connessione ad un database postgres.
Configurare le seguenti properties presenti all'interno di **src/main/resources/application.properties**

spring.datasource.username=[USERNAME]\
spring.datasource.password=[USERNAME]\
spring.datasource.url=[URL_CONNESSIONE_DB]

Una volta configurato il DB, eseguire il comando **mvn spring-boot:run** per eseguire l'applicazione in locale.
I servizi saranno esposti tramite il tomcat-embedded di spring sulla porta configurata all'interno di **src/main/resources/application.properties**:

local.server.port=8080


# Servizi Esposti

Le configurazioni degli endpoint dei servizi integrati sono presenti all'interno di **src/main/resources/application.properties**

fabrick.api.baseUrl=https://sandbox.platfr.io\
fabrick.api.port=\
fabrick.api.letturaSaldo.endpoint=/api/gbs/banking/v4.0/accounts/{accountId}/balance\
fabrick.api.letturaTransazioni.endpoint=/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={from}&toAccountingDate={to}\
fabrick.api.bonifico.endpoint=/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers

Le configurazioni per l'authenticazione del clientHttp sono le seguenti:

fabrick.api.key=FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP\
fabrick.api.authSchema=S2S


```java
GetSaldo - riporta il saldo di un account specifico
  API          gbs-banking-service/interrogation/getSaldo
  METHOD       GET
  QueryParams  accountId Required
  ResponseBodyExample:
          {
              "status": ["OK"|"KO"],
              "error": [],
              "data": {
                  "aggiornatoAl": [DATA_AGGIORNAMENTO],
                  "saldoContabile": [SALDO_CONTABILE],
                  "saldo": [SALDO_DISPONIBILE],
                  "currency": "[VALUTA]
              }
          }
          
GetTransazioni - riporta la lista di transazioni di un account specifico [FILTRO TEMPORALE DATA_DA - DATA_A]
  API           gbs-banking-service/interrogation/getTransazioni
  METHOD        GET
  QueryParams   accountId             Required
                fromAccountingDate    Required Formato(yyyy-MM-dd)
                toAccountingDate      Required Formato(yyyy-MM-dd)
  ResponseBodyExample:
          {
              "status": ["OK"|"KO"],
              "error": [],
              "data": {
                  "transazioni": [
                        {
                            "transactionId": "428524",
                            "operationId": "00000000428524",
                            "accountingDate": "2019-06-28",
                            "valueDate": "2019-07-01",
                            "type": {
                                "enumeration": "GBS_TRANSACTION_TYPE",
                                "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
                            },
                            "amount": -38.9,
                            "currency": "EUR",
                            "description": "PD VISA CORPORATE 05"
                        }]
          }
          
EseguiBonifico - esegue un'operazione di bonifico (Money-Transfert)
  API           gbs-banking-service/dispositive/eseguiBonifico
  METHOD        POST
  QueryParams   -
  RequestBodyExample:
          {
              "accountId":[ACCOUNT_ID],                     REQUIRED
              "creditor": {
                  "name": [NOME_RICEVENTE],                 REQUIRED
                  "account": {
                      "accountCode": [IBAN_RICEVENTE],      REQUIRED
                      "bicCode": [BIC_CODE_BANCA_RICEVENTE] REQUIRED
                  }
              },
              "description": [DESCRIZIONE],                 REQUIRED
              "amount": 800,                                REQUIRED
              "currency": "EUR"                             REQUIRED
          }
  ResponseBodyExample:
          {
            "status": ["OK"|"KO"],
            "error": [],
            "data": {
              "orderId": "180060099",
              "cro": "58643941200",
              "uri": "NOTPROVIDED",
              "amount": {
                "senderAmount": "1000.00",
                "senderCurrency": "EUR"
              },
              "feeType": "SHA",
              "fees": [
                {
                  "amount": "3.50",
                  "currency": "EUR",
                  "code": "MK003",
                  "description": "Commissione valutaria"
                }
              ],
              "date": "26/08/2017",
              "taxRelief": {
                "taxReliefId": "L027",
                "description": "Bonus facciate",
                "receiverFiscalCode": "45632198758",
                "beneficiaryType": "NATURAL_PERSON",
                "naturalPersonBeneficiary": {
                  "fiscalCode1": "ABCDEF81L04A859O",
                  "fiscalCode2": "",
                  "fiscalCode3": "",
                  "fiscalCode4": "",
                  "fiscalCode5": ""
                },
                "legalPersonBeneficiary": {
                  "fiscalCode": "",
                  "legalRepresentativeFiscalCode": ""
                }
              }
            }
          }
  
