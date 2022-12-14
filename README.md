Kotlin library for [voting systems](https://en.wikipedia.org/wiki/Voting_system), with a strong accent on the [Condorcet method](https://en.wikipedia.org/wiki/Condorcet_method) and it's derivatives.


## Usage exemple
```kotlin
// Create a poll to store ballots
var poll = emptyPoll<Char>()

// Add ballots to the poll
// Theses ballot contains the candidates ordered by preferences
poll += ballot('A', 'C', 'B') to 23
poll += ballot('B', 'C', 'A') to 19
poll += ballot('C', 'B', 'A') to 16
poll += ballot('C', 'A', 'B')
poll += ballot('C', 'A', 'B')

// Compute and return the result
// The result is an instance of Ballot which contains the candidates ordered from the winners to the losers
val schulze = poll.getResult() // [[C], [B], [A]] (Use the Schulze method by default)

// Eventualy get the result of other voting methods
val condorcet = poll.getResult(CondorcetMethod)            // [[C], [B], [A]] (identical of the Schulze method in this case)
val relativeMajority = poll.getResult(RelativeMajority)    // [[A], [B], [C]]
```

Depending on the given ballots and the used method, there can be status quo between some candidates.
In such case `poll.result()` would return something like `[[A, B], [C]]` which would mean : **A** and **B** are ex aequo, but both win agains **C**.




