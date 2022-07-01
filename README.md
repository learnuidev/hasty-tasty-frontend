# vishalgautam.ca

## Blogs

---

### Getting started with AWS Amplify

#### Chapter 1: Setting up the environment

Setting up the dev environment
**Steps**

- 1. aws account [tutorial]()
- 2. aws cli configured [tutorial]()
- 3. aws amplify configured [tutorial]()

#### 2. Deploying SPA's to aws using amplify and amazon corretto

In this example we will look at how we can deploy SPA apps to Clojure

**Steps**

##### 1. Create an project

```
npx create-cljs-app vishalgautam.ca
```

`create-cljs-app` creates a new clojurescript reagent app.

##### 2. Install depdendencies

Once the project is generated, cd into the directory and install dependencies using `yarn`

##### 3. Create `amplify.yml` file and add this configuration

```yml
frontend:
  phases:
    preBuild:
      commands:
        # Step 1: Enable the yum repository in Amazon Linux 2.
        - amazon-linux-extras enable corretto8
        # Step 2: Install Amazon Corretto 8 as JDK
        #  - Installation location is: /usr/jvm/java-1.8.0-amazon-corretto.<cpu_arch>.
        - yum -y install java-1.8.0-amazon-corretto-devel
        # Step 3: Verify Your Installation
        - java -version
        - yarn
    build:
      commands: [yarn build]
  artifacts:
    baseDirectory: public/
    files:
      - '**/*'
```

##### 4. [git] Push

##### 5. [AWS] Create a new amplify app

- Go to aws amplify and create a new app
  - Select host an app. Amplify Hosting is a fully managed hosting service for web apps.
- Next: Connect your repository to build, deploy, and host your web app.
  - Enable github authorization access
  - Select github and click continue
  - Add the repository branch
    - Select the main/master branch and click next
