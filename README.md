http://localhost:8083/twitter/1160911653669613568

http://localhost:8083/twitter/findAll

http://localhost:8083/twitter/paged?page=0&size=50

http://localhost:8083/twitter/slice?page=0&size=50

http://localhost:8083/twitter/favoritedAndRetweeted?favorited=false&retweeted=false&page=0&size=50

http://localhost:8083/twitter/favoritedOrTruncated?favorited=false&truncated=true&page=0&size=50

http://localhost:8083/twitter/findByLang?lang=en

http://localhost:8083/twitter/findByLangNot?lang=en

http://localhost:8083/twitter/findByLangNotIn?langs=en,hi

http://localhost:8083/twitter/findByTextContaining?query=modi

http://localhost:8083/twitter/findByIsQuoteStatus?quoteStatus=true&page=0&size=50

http://localhost:8083/twitter/findByUserDescriptionContaining?quoteString=modi&page=0&size=75  //not working

http://localhost:8083/twitter/findByUserDescriptionContaining2?quoteString=modi&page=1&size=75

http://localhost:8083/twitter/findByUserDescriptionMatchPhrase?quoteString=Narendra%20Modi&page=0&size=75

http://localhost:8083/twitter/findByTextAndUserDescriptionMultiMatch?quoteString=modi%20politics&page=0&size=75


Supported keywords inside method names Keyword	Sample	Elasticsearch Query String
-----------------------------------------------------------------------------------

And

findByNameAndPrice

{"bool" : {"must" : [ {"field" : {"name" : "?"}}, {"field" : {"price" : "?"}} ]}}

Or

findByNameOrPrice

{"bool" : {"should" : [ {"field" : {"name" : "?"}}, {"field" : {"price" : "?"}} ]}}

Is

findByName

{"bool" : {"must" : {"field" : {"name" : "?"}}}}

Not

findByNameNot

{"bool" : {"must_not" : {"field" : {"name" : "?"}}}}

Between

findByPriceBetween

{"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" : ?,"include_lower" : true,"include_upper" : true}}}}}

LessThanEqual

findByPriceLessThan

{"bool" : {"must" : {"range" : {"price" : {"from" : null,"to" : ?,"include_lower" : true,"include_upper" : true}}}}}

GreaterThanEqual

findByPriceGreaterThan

{"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" : null,"include_lower" : true,"include_upper" : true}}}}}

Before

findByPriceBefore

{"bool" : {"must" : {"range" : {"price" : {"from" : null,"to" : ?,"include_lower" : true,"include_upper" : true}}}}}

After

findByPriceAfter

{"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" : null,"include_lower" : true,"include_upper" : true}}}}}

Like

findByNameLike

{"bool" : {"must" : {"field" : {"name" : {"query" : "?*","analyze_wildcard" : true}}}}}

StartingWith

findByNameStartingWith

{"bool" : {"must" : {"field" : {"name" : {"query" : "?*","analyze_wildcard" : true}}}}}

EndingWith

findByNameEndingWith

{"bool" : {"must" : {"field" : {"name" : {"query" : "*?","analyze_wildcard" : true}}}}}

Contains/Containing

findByNameContaining

{"bool" : {"must" : {"field" : {"name" : {"query" : "?","analyze_wildcard" : true}}}}}

In

findByNameIn(Collection<String>names)

{"bool" : {"must" : {"bool" : {"should" : [ {"field" : {"name" : "?"}}, {"field" : {"name" : "?"}} ]}}}}

NotIn

findByNameNotIn(Collection<String>names)

{"bool" : {"must_not" : {"bool" : {"should" : {"field" : {"name" : "?"}}}}}}

Near

findByStoreNear

Not Supported Yet !

True

findByAvailableTrue

{"bool" : {"must" : {"field" : {"available" : true}}}}

False

findByAvailableFalse

{"bool" : {"must" : {"field" : {"available" : false}}}}

OrderBy

findByAvailableTrueOrderByNameDesc

{"sort" : [{ "name" : {"order" : "desc"} }],"bool" : {"must" : {"field" : {"available" : true}}}}


