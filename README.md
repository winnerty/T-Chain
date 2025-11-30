# TCoin - Java Cryptocurrency

This project demonstrates the core ideas behind a simple cryptocurrency and blockchain written in Java.

It includes:

- Creating wallets: `new Wallet();`
- Generating public/private key pairs using Elliptic Curve Cryptography (ECC)
- Securing transactions with digital signatures
- Sending funds via:  
  `Block.addTransaction(walletA.sendFunds(walletB.publicKey, 20));`

---

## Features

- **Wallets**  
  Generate ECC key pairs used to sign and verify transactions.

- **Blockchain**  
  Each block contains a timestamp, previous hash, Merkle root, nonce, and a list of transactions.  
  Blocks are mined by finding a hash that starts with a certain number of zeros (difficulty).

- **Transactions**  
  Signed by the sender’s private key to prove ownership of funds.

---

## Quick Example

```java
Wallet walletA = new Wallet();
Wallet walletB = new Wallet();

Block block1 = new Block("0");
block1.addTransaction(walletA.sendFunds(walletB.publicKey, 20));

int difficulty = 3;
block1.mineBlock(difficulty);
