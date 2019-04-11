#!/bin/bash

touch results_bswabe.csv
echo 'Benchmarking Results for 10 Attributes for 10 iterations' | pr -1 -t -s >> results_bswabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_bswabe.csv;

paste results_bswabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.bswabe.Demo10 | pr -3 -t -s >> results_bswabe.csv;
i=$((i+1))
done)

echo '\n'
echo 'Benchmarking Results for 20 Attributes for 10 iterations' | pr -1 -t -s >> results_bswabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_bswabe.csv;
paste results_bswabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.bswabe.Demo20 | pr -3 -t -s >> results_bswabe.csv;
i=$((i+1))
done)

echo '\n'
echo 'Benchmarking Results for 30 Attributes for 10 iterations' | pr -1 -t -s >> results_bswabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_bswabe.csv;
paste results_bswabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.bswabe.Demo30 | pr -3 -t -s >> results_bswabe.csv;
i=$((i+1))
done)
