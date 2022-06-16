# Adl automation
ADL Repoistory


## Steps to contribute to this framework:
1. Clone this repository from GitHub into your local desktop.
2. Create a branch:
	```bash
	git checkout -b <branch_name>.
	```
3. 	Make your changes and commit them:
	```
	git commit -m '<commit_message>'
	```
4. Push to the original branch: 
	```
	git push origin <branch_name>
	```
5. Create a pull request and assign to your reviewer.

## How to write tests and How to organize the tests.
Current Cypress framework is structured in four layer. Design of current framework is comprised of -

1. End to End test - All test are written in cypress/integration/ folder. Test file should have *.spec.js filename in the end.
2. Page Actions - All repeatable action are written in this folder. 
3. Page Object - All object which are utilised actions files are being declared here and returned at per the requirement of the test.
4. Locator - CSS locator elements are stored here. It is in JSON format.
5. Test data - All user specific data is present here. ie- Name, Job type etc. File is present in fixture folder.

