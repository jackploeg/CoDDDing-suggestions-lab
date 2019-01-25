# Implementing a Bounded Context in Code

This repository has several labs to guide you from tests to production ready software in Java and C#.

There are 4 labs that build up on each other and you can reach them through the branches. Each Lab has a start and a end solution.
Here are the labs:

* Lab 1 - Implementing a bounded context using Outside-in TDD
* Lab 2 - Supple design - Make the potential of the model clear
* Lab 3 - Deep Model - refactoring to deeper insights (There are two parts to this lab)
* Lab 4 - Coding Lab 4: Ports and Adapters aka Hexagonal architecture - Protecting your bounded context domain model

## Lab 1 - Implementing a bounded context using Outside-in TDD

Your task is to let the two tests in SeatAllocatorShould test pass on to the model we designed in the responsiblity mapping. You can do this by yourself, in a pair or even do a ensemble programming with multiple people.
Start implementing the tests using the ExternalDependencies `AuditoriumSeatingAdapter` were you can `GetAuditoriumSeating` to use 'AuditoriumSeating' as input state to your model for the examples modelled in the example mapping.

You can find the states visualised in `../../AuditoriumLayoutExamples.md`, use the corresponding ID to call the state.

We won't be doing puristic TDD, as in we will use the domain model designed from the responsbility mapping to create objects which are the expression of our ubiqituous language in code. You can just create them in the TheatherSuggestions.Tests project and focus on passing the tests on our domain model. We deal with project structure in a later lab.

![Visual lab 1](./lab1-visual.jpg)

## Lab 2 - Supple design - Make the potential of the model clear

We extracted our domain model to the `SeatsSuggestions` project, and refactored our stub/fake mechanism int he Tests. Now it is time to implement the next test in `SeatAllocatorShould` called `Offer_several_suggestions_ie_1_per_PricingCategory_and_other_one_without_category_affinity` which fails. You need to find out why it failed, that is why we gave you a couple of unit tests to work with and find the bug!
