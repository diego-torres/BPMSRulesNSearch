[condition][cloudQuote]There is a CloudQuote=cloudQuoteRequest : CloudQuote()
[condition][cloudQuote]- provider is {provider} = cloudProvider == "{provider}"
[condition][cloudQuote]- client location is {location} = clientLocation == "{location}"
[consequence][cloudQuote]Add recommendation {recommendation} to CloudQuote=modify(cloudQuote) \{recommendations = cloudQuote.recommendations + "<br/> -" + {recommendation}\}
[condition][dataIngestion]Theres is a DataIngestion=dataIngestion: DataIngestion()
[condition][dataIngestion]- users are less than {lower} and more than {upper}=users<{lower}, users>{upper}
[condition][dataIngestion]- developers are less than {lower} and more than {upper}=developers<{lower}, developers>{upper}
[consequence][]logRule=System.out.println("the rule that executed is: " + drools.getRule());
[consequence][policy]Add surcharge {surcharge} to cloudQuote=modify(cloudQuote) \{price = cloudQuote.price + {surcharge}\}
