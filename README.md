# Junwei_Wang_Java_CPABE

There are two scripts, namely “Benchmarking_script_bswabe.sh” and “Benchmarking_script_cpabe.sh” that generate the benchmarking results for 'bswabe' and 'cpabe' respectively. This is a Java based realization for Ciphertext-Policy Attribute-Based Encryption that is developed by Junwei Wang (https://github.com/junwei-wang/cpabe).

For installing cpabe, follow the  instructions given in the build.md file (https://github.com/junwei-wang/cpabe/blob/master/BUILD.md).

The files that will be used to obtain the benchmarking results are:

- Demo.java (/cpabe/cpabe-demo/src/main/java/co/junwei/cpabe/Demo.java) - is the file that creates the benchmarking results for cpabe keygen, encryption and decryption. In the same path (/cpabe/cpabe-demo/src/main/java/co/junwei/cpabe/) as above, there are 3 other files namely, Demo10.java, Demo20.java, and Demo30.java which are used to generate benchmarking results of cpabe for 10 attributes, 20 attributes and 30 attributes respectively.

- Similarly, Demo.java (/cpabe/cpabe-demo/src/main/java/co/junwei/bswabe/Demo.java) - is the file that creates the benchmarking results for bswabe keygen, encryption and decryption. In the same path (/cpabe/cpabe-demo/src/main/java/co/junwei/bswabe/), there are 3 other files namely, Demo10.java, Demo20.java, and Demo30.java which are used to generate benchmarking results of bswabe for 10 attributes, 20 attributes and 30 attributes respectively.

1. The script for generating the benchmarking results (Keygen, encryption, and decryption time) for cpabe is written in the file “Benchmarking_script_cpabe.sh”. We generate results of 10 iterations for each of the attribute set. You can run this script using: 
*“sudo ./ Benchmarking_script_cpabe.sh”*
All the results will be saved in the consecutive column of “results_cpabe.csv” file. The results from “results_cpabe.csv” file can then be used to calculate the average and then to show results in the graphical form.

2. The script for generating the benchmarking results (Keygen, encryption, and decryption time) for bswabe is written in the file “Benchmarking_script_bswabe.sh”. We generate results of 10 iterations for different attribute sets. You can run this script using: 
*“sudo ./ Benchmarking_script_bswabe.sh”* 
All the results will be saved in the consecutive column of “results_bswabe.csv” file. The results from “results_bswabe.csv” file can then be used to calculate the average and then to show results in the graphical form.



