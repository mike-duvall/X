number_prettifier
=================


Status - Completed



Todos
------


* None


Completed
----------
* Handle example scenarios
    * input: 1000000 output: 1M

    * input: 2500000.34 output: 2.5M

    * input: 532 output: 532

    * input: 1123456789 output: 1.1B

* Add checkstyle checks

* Handle additional scenarios
    * 2M
    * 1B
    * 1T
    * 1.2T

* Handle edge cases
    * Zero
    * 999999
    * 999999999
    * 999999999999
    * 1234556.892834323

* Handle error scenarios
    * Quadrillion and over
    * Negative numbers

* Handle corner cases
    * Others?

* Throughout:  Cleanup and refactor code

* Write overview
    * Include assumptions on requirements for negative numbers
    * Include comments on not using brackets in some if,then,else statements, ala Uncle Bob
