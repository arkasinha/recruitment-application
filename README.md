# recruitment-application
Simple recruitment application

Features:

Job Offer
1. Creating Job Offers
2. Getting details of a job offer
3. Getting a list of all job offers
4. Track applications per offerTec

Job Application
1. Submit an application
2. Get details of an application

# Sequence of events:

1. User creates one or more offers using /createOffer REST service

2. Candidate views lists of all available offers using /listAllOffers

3. Candidate views details of one offer using /getOfferDetails

4. Candidate submits an application for a selected offer using /applyToOffer

5. User and Candidate receive notification

6. User views all applications for an offer using /getApplicationsForOffer

7. User scrolls through this list and selects applications to view details using /getApplicationDetails

8. User goes through the application and updates the application status by using /updateApplication

# Project Structure:

1. Endpoints are kept at com.hr.recruitment.controller

2. Service classes at com.hr.recruitment.service

3. Repositories are kept at com.hr.recruitment.repository

4. application.properties contain Email configuration, JPA/Hibernate/H2 settings

5. schema.sql contains commands for creating the tables

6. Unit tests are kept under src/test/java. Unit tests are not thorough. A few are added as examples

# How to Run & Test the application

1. Application doesn't have a FE yet. 

2. Go to RecruitmentApplication.java, Run the class/main method

3. Postman collection - https://www.getpostman.com/collections/a6d611863d7ee60db6cb 

4. Swagger can be accessed at http://localhost:8080/swagger-ui.html
