#!/usr/bin/env bash
curl -i -H accept:application/json -H content-type:application/json -XPOST --user neo4j:cscie63 http://localhost:7474/db/data/transaction/commit -d \
'{"statements":[{"statement":"CREATE (jWick:Movie { title : "\"'John Wick'"\"}) return id(jWick)} \
,{"statement":"CREATE (cStahelski:Director { name:"\"'Chad Stahelski'"\" }) return id(cStahelski)} \
,{"statement":"CREATE (dLeitct:Director { name:"\"'David Leitct'"\" }) return id(dLeitct)} \
,{"statement":"CREATE (wDafoe:Actor { name:"\"'William Dafoe'"\" }) return id(wDafoe)} \
,{"statement":"CREATE (mNyquist:Actor { name:"\"'Michael Nyquist'"\" }) return id(mNyquist)} \
,{"statement":"CREATE (keanu)-[:ACTS_IN]->(jWick)} \
,{"statement":"CREATE (wDafoe)-[:ACTS_IN]->(jWick)} \
,{"statement":"CREATE (mNyquist)-[:ACTS_IN]->(jWick)}]}' 