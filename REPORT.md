Dear Examiner,

Thank you so much for this challenge and for reviewing my code.

I have had no prior experience with SpringBoot with MongoDB (only with relational databases - PostgreSQL).
My solution reflects what I was able to learn in this week, and I am grateful for this learning experience.

Notes
1) In the Compensation and the Reporting Structure data classes, I replaced the Employee type field with String employeeId,
to manage the findByEmployeeId() methods in the service layers.
I am curious about the non-relational schema for the database and data classes, and want to understand how it functions.

2) The ReportingStructure Service layer was particularly intriguing:
Does a non-persistent document have its own Repository? I found conflicting answers online.
I tried to implement a save() method in the ReportingStructureService layer, which saves the ReportingStructure object,
in a Map<employeeId, ReportingStructure> so that the ReportingStructure object could be read().
However, I am doubtful that this solution works, because, the RestTemplate.getEntity required getBody() from the
data class. Unfortunately, I ran our of time before I could figure out whether I could populate ReportingStructure class 
using the map, or find another solution.
I read about @Transient fields, but not transient documents. I am curious about how non-persistent objects can 
be temporarily saved, so that they can be accessed by the controller method read().
Is there a way to read(), without create()?

3) In the method for numberOfReports, I used a Set<String> collection to account for potential duplicates (of employeeId). 
While the method for retrieving the numberOfReports accounts for the two levels of the tree structure illustration,
beyond that, a recursive method would be better.

Thank you again for the challenge, and I look forward to discussing these topics with you,

Sharon.




