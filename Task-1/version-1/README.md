## Task 1: Implement a customer processing project

Customer processing is when we process large-scale customers into the database, and we store the data of the customer. By using this user store customer from a large-scale data file, which needs to store in the system database in an optimized way and very fast to manage easily. You have to implement a process by which the user can process the file easily and store customer data.

### Expected Works to be Done:

you have to process a file of more than 1 million customers have to store customers in the database table (consider it as a file) You have to filter duplicate, and invalid customers based on their phone number and email, only valid customers will be stored in the table (consider it as a file) You have to store all invalid customers in another separate table (consider it as a file) After storing those data in the table, you have to export the invalid and valid customers into separate files. After exporting those you have to share those exported files with us. For valid customers, you have to export those files in a batch of files including 100k customers with each file. Have to share the total process execution time for exporting files. Project deployment documentation implements service and algorithm for file data processing and storing those data and exporting the files with customer data. You must have to implement a multithread process for your full process. How to Submit: You must upload your project to a private repository

Duration: 6 hours Notes: ● You can not use any third-party library. If we find any piece of code copied from any source which is available online, you will be disqualified. ● We shared a file for you, you have to download and process it. ● Download the file here 1M-customers.txt (https://drive.google.com/file/d/13NuIZEuNMjfgCy9mxlb3Yp-5poPR-CW-) ● You must follow the code standard and proper method definition based on process action. ● Code documentation is preferable. ● The customer's phone number & email from the file must be validated in your process. ● Some examples of valid us phone number format 555-555-5555, (555)555-5555, (555) 555-5555, 555 555 5555, 5555555555, 1 555 555 5555


### Changelog in version-1:

1. Enhanced implementation.
2. More faster than ever
3. 4 threads works simultaneously to make it more effecient
4. Best utilization of CPU is ensured with multithreading
