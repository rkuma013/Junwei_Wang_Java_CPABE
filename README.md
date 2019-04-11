# Junwei_Wang_Java_CPABE

There are two scripts, namely “Benchmarking_script_bswabe.sh” and “Benchmarking_script_cpabe.sh” for generating benchmarking results for the bswabe and cpabe respectively.  This java based Realization for Ciphertext-Policy Attribute-Based Encryption are developed by Junwei Wang (https://github.com/junwei-wang/cpabe).

After installing the cpabe, as given in the build.md file (https://github.com/junwei-wang/cpabe/blob/master/BUILD.md), you can follow the following instruction to get the benchmarking results:

Demo.java (/cpabe/cpabe-demo/src/main/java/co/junwei/cpabe/Demo.java)file is used to for creating the benchmarking results for cpabe keygen, encryption and decryption. In the same path (/cpabe/cpabe-demo/src/main/java/co/junwei/cpabe/) as above, there are 3 more files, namely, Demo10.java, Demo20.java,  and Demo30.java which are used to generate benchmarking results of cpabe for 10 attributes, 20 attributes and 30 attributes respectively.

Similarly, Demo.java (/cpabe/cpabe-demo/src/main/java/co/junwei/bswabe/Demo.java)file is used to for creating the benchmarking results for bswabe keygen, encryption and decryption. In the same path (/cpabe/cpabe-demo/src/main/java/co/junwei/bswabe/) as above, there are 3 more files, namely, Demo10.java, Demo20.java,  and Demo30.java which are used to generate benchmarking results of bswabe for 10 attributes, 20 attributes and 30 attributes respectively.

1. The script for generating the benchmarking results (Keygen, encryption, and decryption time) for cpabe is written in the file “Benchmarking_script_cpabe.sh”. We generate results for 10, 20, and 30 attributes and each results have 10 iterations. You can run this script using: “sudo ./ Benchmarking_script_cpabe.sh” multiple time to get the data for multiple iterations. All the results will be saved in the consecutive column of “results_cpabe.csv” file. The results from “results_cpabe.csv” file can then be used to calculate the average and then to show results in the graphical form.

2. The script for generating the benchmarking results (Keygen, encryption, and decryption time) for bswabe is written in the file “Benchmarking_script_bswabe.sh”. We generate results for 10, 20, and 30 attributes and each results have 10 iterations. You can run this script using: “sudo ./ Benchmarking_script_bswabe.sh” multiple time to get the data for multiple iterations. All the results will be saved in the consecutive column of “results_bswabe.csv” file. The results from “results_bswabe.csv” file can then be used to calculate the average and then to show results in the graphical form.



