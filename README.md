# fruit-shop

Run all tests with 'sbt test'

Shopping cart

● You are building a checkout system for a shop which only sells apples and oranges.

● Apples cost 60p and oranges cost 25p.

● Build a checkout system which takes a list of items scanned at the till and outputs the total cost

● For example: [ Apple, Apple, Orange, Apple ] => £2.05

● Make reasonable assumptions about the inputs to your solution; for example, take a list of strings as input

Step 2
● The shop decides to introduce two new offers

    ○ buy one, get one free on Apples

    ○ 3 for the price of 2 on Oranges

Things which would be better:

● Use BigDecimal for calcs
● Use streams for the discount calc and use parallel streams per discount if hundreds of items

Things which would be better in Scala:

● implicit conversion to currency amount
● case classing
● could use tuple for item counts instead of map, could return sum/discount as tuple
● more human readable specs

