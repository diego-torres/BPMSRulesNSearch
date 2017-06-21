[condition][cloudQuote]There is a CloudQuote=cloudQuoteRequest : CloudQuote()
[condition][cloudQuote]- provider is {provider} = cloudProvider == "{provider}"
[condition][cloudQuote]- client location is {location} = clientLocation == "{location}"
[condition][dataVisualization]Theres is a DataIngestion=dataIngestion: DataVisualization()
[condition][dataVisualization]- There is more than {users} users=endUsers>{users}
[condition][dataVisualization]- There is more than {developers} developers=developers>{developers}
[condition][dataVisualization]- users are less than {lower} and more than {upper}=endUsers<{lower}, users>{upper}
[condition][dataVisualization]- developers are less than {lower} and more than {upper}=developers<{lower}, developers>{upper}
[consequence][]logRule=System.out.println("the rule that executed is: " + drools.getRule());
[consequence][cloudQuote]Add recommendation {recommendation} to CloudQuote=modify(cloudQuote) \{recommendations = cloudQuote.recommendations + "<br/> -" + {recommendation}\}
[consequence][cloudQuote]Add surcharge {surcharge} to cloudQuote=modify(cloudQuote) \{price = cloudQuote.price + {surcharge}\}