1. KISS (Keep It Simple and Short)
    - Condition state, looping => complex statement(X), simple and short
    - Method => has single task, (modularization)
    - Class => field, method in needs

Agile Dev (a.k.a spiral)
    - Spec -> Class design -> implementation -> execution
    - iterating above -> growing up (bottom up)

KISS & Agile
    -

2. DRY (Don't repeat yourself)
    - exclude duplicates, methods should be reusable
    - method : flexibility

3. SRP (Single Responsibility Principle)
    - a class is responsible for only one Job
    - Data Processing role?
    - software readability + maintenance

4. OCP (Open Close Principle)
    - Open for expansion, close for modification
    - immutable as possible (modification can not effect on others)

================================================================
Exercise1 : String inputs exercise
Department & Student : W2 Lecture student refactoring by using arrayList instead of array
Department : id <-> exitFlag mixed debugging
Exercise3 : randomized characters in character array[][]


### Changes
- Student.java -> readWithoutId, Constructor(int id), default constructor, matches(String name)
- Department0.java -> readAll(), search(), findStudent()
