#!/bin/bash

touch results_cpabe.csv
echo 'Benchmarking Results for 10 Attributes for 10 iterations' | pr -1 -t -s >> results_cpabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_cpabe.csv;

paste results_cpabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.cpabe.Demo10 | pr -3 -t -s >> results_cpabe.csv;
i=$((i+1))
done)

echo '\n'
echo 'Benchmarking Results for 20 Attributes for 10 iterations' | pr -1 -t -s >> results_cpabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_cpabe.csv;
paste results_cpabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.cpabe.Demo20 | pr -3 -t -s >> results_cpabe.csv;
i=$((i+1))
done)

echo '\n'
echo 'Benchmarking Results for 30 Attributes for 10 iterations' | pr -1 -t -s >> results_cpabe.csv;
echo '\n'
echo 'keygen','encryption','decryption' | pr -3 -t -s >> results_cpabe.csv;
paste results_cpabe.csv 
(for i in $(seq 1 10)
do
java -cp "jars/*" co.junwei.cpabe.Demo30 | pr -3 -t -s >> results_cpabe.csv;
i=$((i+1))
done)
