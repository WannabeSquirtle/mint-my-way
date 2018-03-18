package com.mintmyway.retrievetransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class RetrieveTransactionsApplication {

	public static void main(String[] args) {

		SpringApplication.run(RetrieveTransactionsApplication.class, args);

		String transactionsFile = "/Users/andrewbachman/Repos/mint-my-way/transactions/transactions-03-11-2018.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(transactionsFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] transaction = line.split(cvsSplitBy);

				System.out.println("Transaction [company= " + transaction[1] + " , amount=" + transaction[3] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
