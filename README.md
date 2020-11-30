# Constraint-Satisfaction-Problem_Quasigroup_Completion

## Quasigroup Completion Problem (QCP)

An order m quasigroup is a Latin square of size m. That is, a m by m multiplication table in which each element occurs once in every row and column. For example,
```
1        2       3       4
4        1       2       3
3        4       1       2
2        3       4       1

is an order 4 quasigroup. 
```

Quasigroup Completion Problem asks to complete a quasigroup given some of its entries. 
For example, partially specified quasigroup
```
1      0        0       4
0      0        2       0
3      0        1       0
0      3        0       0

could be completed as the first example above.
>Here 0 means slot is empty.We have to fiilup it.That's the task!
```

### Practical application:
- Dynamic wavelength routing in Fiber Optic Networks can be directly mapped into the Quasigroup Completion Problem.



## Constraint Satisfaction Problems (CSP)
```
- How to formulate? V, D, C
- How to solve? Backtracking algorithms
```
## Solving a CSP

- [x] Simple Backtracking (BT)
- [x] Forward Checking (FC)
- [ ] Maintaining Arc Consistency (MAC)


## Varible ordering heuristics: 

- [x] SDF: Smallest Domain First. The variable chosen is the one with the smallest domain.
 
- [ ] max-static-degree:The variable chosen is the one with the maximum degree in the original constraint graph.

- [x] max-dynamic-degree:The variable chosen is the one with the maximum degree to non-assigned variables. Also, called max-forward-degree.

- [x] brelaz: The variable chosen is the one with the smallest domain.Ties are broken by choosing the variable with smallest domain and maximum forward degree.

- [x] domdeg: The variable chosen is the one that minimizes the ratio of domain size to degree in the original constraint graph.x

- [x] domddeg: The variable chosen is the one that minimizes the ratio of domain size to forward degree (i.e.the number of adjacent uninstantiated variables).

- [x] random: A random (unassigned or uninstantiated) variable is chosen.x

- [ ] IBS: Impact-Based Heuristic. Selects the variable having the largest impact and the value having the smallest impact.




## As performance measures:
* number of consistency checking 
* number of fails



