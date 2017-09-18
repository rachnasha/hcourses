curl -i -H accept:application/json -H content-type:application/json -XPOST \
--user neo4j:cscie63 http://localhost:7474/db/data/transaction/commit -d \
'{"statements":[{"statement":"CREATE (pat1:Strawberry {title:\"'He'\" ,year:\"'1999-03-31'\" }) RETURN pat1"}, \
{"statement":"CREATE (pat2:Peach {title:\"'He'\" ,year:\"'1999-03-31'\" }) RETURN pat2"} \
]}'