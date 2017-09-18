s1=select(db1.tbl3.col4,220000000,330000000
f1=fetch(db1.tbl3.col4,s1)
tuple(f1)
s2=select(db1.tbl3.col4,440000000,550000000
f2=fetch(db1.tbl3.col4,s2)
tuple(f2)
s3=select(db1.tbl3.col4,440000000,600000000
f3=fetch(db1.tbl3.col4,s3)
tuple(f3)
s4=select(db1.tbl3.col4,220000000,440000000
f4=fetch(db1.tbl3.col4,s4)
tuple(f4)
s5=select(db1.tbl3.col4,220000000,600000000
f5=fetch(db1.tbl3.col4,s5)
tuple(f5)
s6=select(db1.tbl3.col4,-220000000,600000000
f6=fetch(db1.tbl3.col4,s6)
tuple(f6)
s7=select(db1.tbl3.col4,-1,900000000
f7=fetch(db1.tbl3.col4,s7)
tuple(f7)
s8=select(db1.tbl3.col4,-900000000,900000000
f8=fetch(db1.tbl3.col4,s8)
tuple(f8)


Scala

SimpleClient 220000000 330000000
SimpleClient 440000000 550000000
SimpleClient 440000000 600000000
SimpleClient 220000000 440000000
SimpleClient 220000000 600000000
SimpleClient -220000000 600000000
SimpleClient -900000000 900000000