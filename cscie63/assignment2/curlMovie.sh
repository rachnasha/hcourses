curl -i -H accept:application/json -H content-type:application/json -XPOST --user neo4j:cscie63 http://localhost:7474/db/data/transaction/commit -d  \
'{"statements": \
[{"statement":"CREATE (matrix1:Movie { title : \"'The Matrix'\", year : \"'1999-03-31'\" }) return id(matrix1)"}, \
{"statement":"CREATE (matrix2:Movie { title : \"'The Matrix Reloaded'\", year : \"'2003-05-07'\" }) return id(matrix2)"}, \
{"statement":"CREATE (matrix3:Movie { title : \"'The Matrix Revolutions'\", year : \"'2003-10-27'\" }) return id(matrix3)"}, \
{"statement":"CREATE (keanu:Actor { name:\"'Keanu Reeves'\" }) return id(Keanu)"}, \
{"statement":"CREATE (laurence:Actor { name:\"'Laurence Fishburne'\" })"}, \
{"statement":"CREATE (carrieanne:Actor { name:\"'Carrie-Anne Moss'\" })"}, \
{"statement":"CREATE (keanu)-[:ACTS_IN { role : \"'Neo'\" }]->(matrix1)"}, \
{"statement":"CREATE (keanu)-[:ACTS_IN { role : \"'Neo'\" }]->(matrix2)"}, \
{"statement":"CREATE (keanu)-[:ACTS_IN { role : \"'Neo'\" }]->(matrix3)"}, \
{"statement":"CREATE (laurence)-[:ACTS_IN { role : \"'Morpheus'\" }]->(matrix1)"}, \
{"statement":"CREATE (laurence)-[:ACTS_IN { role : \"'Morpheus'\" }]->(matrix2)"}, \
{"statement":"CREATE (laurence)-[:ACTS_IN { role : \"'Morpheus'\" }]->(matrix3)"}, \
{"statement":"CREATE (carrieanne)-[:ACTS_IN { role : \"'Trinity'\" }]->(matrix1)"}, \
{"statement":"CREATE (carrieanne)-[:ACTS_IN { role : \"'Trinity'\" }]->(matrix2)"}, \
{"statement":"CREATE (carrieanne)-[:ACTS_IN { role : \"'Trinity'\" }]->(matrix3)"}]}'