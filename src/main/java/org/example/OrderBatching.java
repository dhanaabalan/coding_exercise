package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderBatching {

    public static class Transaction {
        String id;
        int priority;
        double amount;

        public Transaction(String id, int priority, double amount) {
            this.id = id;
            this.priority = priority;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id='" + id + '\'' +
                    ", priority=" + priority +
                    ", amount=" + amount +
                    '}';
        }
    }

    public List<List<Transaction>> batchTransactions(List<Transaction> transactions, int k) {
 List<Transaction> sorted=new ArrayList<>(transactions);
 sorted.sort(Comparator.comparingInt((Transaction t)->t.priority).reversed());
        System.out.println(sorted);
        List<List<Transaction>> batches = new ArrayList<>();
        for (int i = 0; i < sorted.size(); i += k)
        {
            batches.add(new ArrayList<>(sorted.subList(i, Math.min(i + k, sorted.size()))));
        }
        return batches;
    }

   public static void main(String args[])
   {
       List<Transaction> inputlist=List.of(
              new Transaction("T1",2,100),
               new Transaction("T2",5,300),
               new Transaction("T3",2,50),
               new Transaction("T4",4,399));

       System.out.println(inputlist);
       OrderBatching input=new OrderBatching();
       List<List<Transaction>> result=input.batchTransactions(inputlist,2);
       System.out.println(result);

       for (int i = 0; i < result.size(); i++)
       {
           System.out.println("Batch " + (i + 1) + ": " + result.get(i));
             }


   }
}