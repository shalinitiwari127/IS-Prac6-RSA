/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispracs;

import java.io.*;
import java.util.*;
import java.math.*;
public class Rsa
{
 public static void main(String args[]) throws IOException
 {
 Scanner sc=new Scanner(System.in);
 int p,q,n,z,d=0,e,i;
  int w;
 Rsa rsa = new Rsa();
 do{
  System.out.println("Enter 1:RSA,2:Euclidean,3:Extended Euclidean: 4: Encrypt File");
  int ch = sc.nextInt();
  switch(ch){
      case 1:
          rsa.RSA2();
          break;
      case 2:
          rsa.euclidiean();
          break;
      case 3:
          rsa.xeuclidiean();
          break;
      case 4:
          RSA3 rsa1 = new RSA3();
        DataInputStream in = new DataInputStream(System.in);
        String teststring = "";
        File f=new File("E:\\input.txt");
        File f1=new File("E:\\rsa_cipher.txt");
        BufferedReader br=new BufferedReader(new FileReader(f));
        BufferedWriter b1=new BufferedWriter(new FileWriter(f1));
        String c;
        while((c=br.readLine())!=null){
            teststring=teststring+c;
        }
        byte[] encrypted = rsa1.encrypt(teststring.getBytes());
        // decrypt
        byte[] decrypted = rsa1.decrypt(encrypted);
        String d1=new String(encrypted);
        b1.write(d1);
        System.out.println("Decrypted String: " + new String(decrypted));
        br.close();
        b1.close();
         break; 
  }
  System.out.println("Do you want to continue ,if yes enter 1");
  w = sc.nextInt();
 }while(w==1);
 }
 void RSA2(){
     Scanner sc=new Scanner(System.in);
 System.out.println("Enter the number to be encrypted and decrypted");
 int msg=sc.nextInt();
 int p,q;
     System.out.println("Enter 1st prime number p");
 p=sc.nextInt();
 System.out.println("Enter 2nd prime number q");
 q=sc.nextInt();
 int n=p*q;
 int phi=(p-1)*(q-1);
 System.out.println("the value of phi(n) = "+phi);
 int e;
 for(e=2;e<phi;e++)
 {
 if(gcd(e,phi)==1)
 {
 break;
 }
 }
 int d=0;
 System.out.println("the value of e = "+e);
 int r1=phi;
 int r2=e;
 int rem=0;
 int t=0;
 int t1=0,t2=1;
     System.out.println("q\tr1\tr2\tr\tt1\tt2\tt");
 while(r2!=0){
     int qu= r1/r2;
     System.out.print(qu+"\t");
      rem=r1%r2;
      t=t1-(t2*qu);
     System.out.print(r1+"\t");
     System.out.print(r2+"\t");
     System.out.print(rem+"\t");
     System.out.print(t1+"\t");
     System.out.print(t2+"\t");
     System.out.println(t+"\t");
     r1=r2;
     r2=rem;
     t1=t2;
     t2=t;     
 }
 if(t1<0)
     d=t1+phi;
 else
     d=t1;
 BigInteger msgback; double c;
 System.out.println("the value of d = "+d);
 c=(Math.pow(msg,e))%n;
 System.out.println("Encrypted message is :");
 System.out.println(c);
 BigInteger N = BigInteger.valueOf(n);
 BigInteger C = BigDecimal.valueOf(c).toBigInteger();
 msgback = (C.pow(d)).mod(N);
 System.out.println("Decrypted message is :");
 System.out.println(msgback);

 }
 static int gcd(int e, int z)
 {
 if(e==0)
 return z;
 else
 return gcd(z%e,e);
 }
   void xeuclidiean ()
   {
       int q,r,r1,r2,s1=1,s2=0,s,t1=0,t2=1,t;
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter r1  ");
       r1 = sc.nextInt();
       System.out.println("Enter r2 ");
       r2 = sc.nextInt();
       int n=r1;
       int b=r2;
       System.out.println("q \t r1 \t r2 \t r \t s1 \t s2 \t s \t t1 \t t2 \t t");
       while (r2>0)
       {
           q=r1/r2;
           r = r1-(q*r2);
           r1=r2;
           r2=r;
           t=t1-(q*t2);
           t1=t2;
           t1=t;
           s=s1-(s2*q);
           s1=s2;
           s2=s;
           System.out.println(q+" \t "+r1+" \t "+r2+" \t "+r+" \t "+s1+" \t "+s2+" \t "+s+" \t "+t1+" \t "+t2+" \t"+ t);
       }
       System.out.println("GCD is  "+r1);
   }
   static int phi(int n) 
{ 
    // Initialize result as n 
    int result = n;  
    // Consider all prime factors  
    // of n and subtract their 
    // multiples from result 
    for (int p = 2; p * p <= n; ++p) 
    {
        if (n % p == 0)  
        {         
            // If yes, then update 
            // n and result 
            while (n % p == 0) 
                n /= p; 
            result -= result / p; 
        } 
    } 
    if (n > 1) 
        result -= result / n; 
    return result; 
} 
void euclidiean ()
   {
       int q,r,r1,r2,s1=1,s2=0,s,t1=0,t2=1,t;
       Scanner sc = new Scanner(System.in);
       System.out.println(" Enter r1  ");
       r1 = sc.nextInt();
       System.out.println(" Enter r2 ");
       r2 = sc.nextInt();
       int n=r1;
       int b=r2;
       System.out.println("q\tr1\tr2\trem");
       while (r2>0)
       {
           q=r1/r2;
           System.out.print(q+"\t");
           r = r1-(q*r2);
           r1=r2;
           System.out.print(r1+"\t");
           r2=r;
           System.out.print(r2+"\t");
           System.out.println(r);
       }
       System.out.println(" GCD is  "+r1);
   }
}
class RSA3
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private Random     r;
    public RSA3()
    {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("p is "+p);
        System.out.println("q is "+q);
        System.out.println("N is "+N);
        System.out.println("phi is "+phi);
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
         System.out.println("e is "+e);
        d = e.modInverse(phi);
        System.out.println("d is "+d);
    }
    public RSA3(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
    // Encrypt message
    public byte[] encrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
    // Decrypt message
    public byte[] decrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
 }
