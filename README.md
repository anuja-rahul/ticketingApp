# Real-Time Event Ticketing System

![Java](https://img.shields.io/badge/java-000?style=for-the-badge&logo=openjdk&logoColor=f89820)
![JWT](https://img.shields.io/badge/-JWT-000?style=for-the-badge&logo=json-web-tokens)
![Spring](https://img.shields.io/badge/spring-000?style=for-the-badge&logo=spring&logoColor=green)
![HIBERNATE](https://img.shields.io/badge/Hibernate-000?style=for-the-badge&logo=hibernate&logoColor=white)
![POSTGRES](https://img.shields.io/badge/-postgresql-000?style=for-the-badge&logo=postgresql)

![GitHub](https://img.shields.io/github/forks/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![GitHub](https://img.shields.io/github/license/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![GitHub](https://img.shields.io/github/stars/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![Contributors](https://img.shields.io/github/contributors/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![Watchers](https://img.shields.io/github/watchers/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;

```shell
  _____ _    _       _   _             _   ___ ___
 |_   _(_)__| |_____| |_(_)_ _  __ _  /_\ | _ \_ _|
   | | | / _| / / -_)  _| | ' \/ _` |/ _ \|  _/| |
   |_| |_\__|_\_\___|\__|_|_||_\__, /_/ \_\_| |___|  v1.0
                               |___/
   running on Spring Boot 3.3.4
```

[![layers](https://mermaid.ink/img/pako:eNpVUsGO2yAU_BXr7dVxsLGxzVa9NNtTq0q7PVW-vBgco8XGArzdNMq_F5Ooq554M8O8xwAX6I2QwOFkcRmTb8-P3ZwkX62Z_dMskk-73efk8PNHZMN6I74E1RqtpY38B7zJL9K-qV5G7V7fhGe5GKe8seeofcD7HPR4RLcZN7nX6NxBDomQA67aJ4PSmj8QQlIX5r1K_kApvde730r4kZfL-yOkMEk7oRIh1mXr1IEf5SQ74KEUaF876OZr2IerNy_nuQfu7SpTWBeBXh4UhtuY_iefxHZS4ANqF0htUMgAL-DPS7w_5Xzo2Jt5UKeNX60O9Oj94vh-v8nZSflxPWa9mfZOiRGtH99atmcFa7CgktUUK0pFf8zbZijKfBA1yQuE6zWFBeet6zvwhmSkKvKGVoxWtGyqFM7Ac5LlJWN5WbZ0o1nw_DEmpCBZW7O8aauKVbRmpA4GGdN8vz19_AEpWLOexn8Bw7xf0R7x9S-eDK5R?type=png)](https://mermaid.live/edit#pako:eNpVUsGO2yAU_BXr7dVxsLGxzVa9NNtTq0q7PVW-vBgco8XGArzdNMq_F5Ooq554M8O8xwAX6I2QwOFkcRmTb8-P3ZwkX62Z_dMskk-73efk8PNHZMN6I74E1RqtpY38B7zJL9K-qV5G7V7fhGe5GKe8seeofcD7HPR4RLcZN7nX6NxBDomQA67aJ4PSmj8QQlIX5r1K_kApvde730r4kZfL-yOkMEk7oRIh1mXr1IEf5SQ74KEUaF876OZr2IerNy_nuQfu7SpTWBeBXh4UhtuY_iefxHZS4ANqF0htUMgAL-DPS7w_5Xzo2Jt5UKeNX60O9Oj94vh-v8nZSflxPWa9mfZOiRGtH99atmcFa7CgktUUK0pFf8zbZijKfBA1yQuE6zWFBeet6zvwhmSkKvKGVoxWtGyqFM7Ac5LlJWN5WbZ0o1nw_DEmpCBZW7O8aauKVbRmpA4GGdN8vz19_AEpWLOexn8Bw7xf0R7x9S-eDK5R)

## *Project proposal*

[![class](https://mermaid.ink/img/pako:eNqlV21P20gQ_iuWpUpBBJIQYkJUIVGKVE70WkHak6p8WbwTe4W969tdG1IOfvvN2mvHdkxIW74Qz84zr8_M2k-uLyi4M3fB_Ygo9ZGRQJJ4wR38yyXOnPn3oJ2nQmb-3r-_5Jrp1dnZWrbvXAseOIzWRbdaMhRCBlz_TWKon11xDQFIh2SEReQugsKP6tLRQpNo23l-dAMREAU3RHc6isljYeKCJMTH8OtKmWDUIZRaJz3GteOLlOu9DS0JschstD17_Lzg9ZJ9B06F_JOS8Va1rDjLDV9gyzbDSvkr0VykSosY5LmfZ_QnYaUK5CuhJejqQcgulBQRGMFg4Fx8u51_-Xx542B5vl99_YUsioJ_FSKqJ7DvqBX3Qyk4-wm0s40FOdTeqyBL8B36WhzegsyYD80wdvVsnSWp9EMk6w7ubiARimkhV83OreXN7imSQc-6KSLYm1lTdbUl4_TD6or2bLdR6UuimeAkeim0X3Zh069GV_lo2XmxAX2zDOu1GLe1ISSC32J1LipqdLV54NsIm0dzFoPSJE5qPezebP-mJA9jy4o49zXLUOX3oy82wtVuaVU7l1KgHft0nZsuf20p-4XgGkc7AtluvaqdNdPAs0RwBUWKL9dMYecD0OdRud97e1v0LTENovjZYPAOwGpCWxOyA7Q1so0id7Pzr4fuXWGpHQAHiZfVXNwD7xnifwSNl6HKSW9_NyL7gNsPCHcyEjFaIa05bR76znY7rQjPUx12hli3EglCzfObw9nIjqBpvPaZj3G29fvtS6M7umsRBE1y7WMwQWkNGapIALi4zPLttHAppZCfCKdR206YC_Pz3uWjD_lacjqMvXuHhIiIOVYhS5RzB_oBAHUNPRgoBy05qiiinaaNxX1wcFZu_pmzcGPCMXC1cOvqZR_WujUDBoXVa0Hy23CtX1owyj6JopZ2bV67MYxnyKF2WGa5Gv32a4RBaEn8e4VXToR1WApZQlvbzcDtO5FBYQ-xasUhexNYq1sOLGauxK8MMu_S-Zpw2KvCXJ3fxlZtIo29cgKLHpZThYP7z7wMqG3h9evPGJSA1MTX3e2Vr9s0qPqoqCqfeSiBUEuv6n2llpyt6MHBf2fOTcq5eYku-hgnEcRosQqj3btdMJX5szrb8ngpLduA_8XrTjaQVX0q-FKKuEr5OicG5gtmLtVGHHYhdHBoWwxvo2ouGhvDQIpFocqQtvjZAbrgbt9FWEwYxY-ufCPhFIVY-YVrIJTIe6P4jHpIC3GLjXdnWqbQd9PEsNN-obmzJYlUJb2khoSV0KxswMcnV68S83kX4EWLJn3Blyww8lRGKA61TtRsMDDHhwHTYXp36It4oBgNidRhduoNvCNvSo7G4J2MyWQ8pv7d6HS6PDoeLenJcHRE3OfnvpsQbqw-urPp8HA4ORpNxxNvPBkfTyd9d-XORsPD0bHnjY6PT8dG7CHmpxCYxvDw9MQbTU8nE28yPvGGJwiAPJvPxZdp_oHad6VIg7BKEP39yOH58_P_FRS_ZQ?type=png)](https://mermaid.live/edit#pako:eNqlV21P20gQ_iuWpUpBBJIQYkJUIVGKVE70WkHak6p8WbwTe4W969tdG1IOfvvN2mvHdkxIW74Qz84zr8_M2k-uLyi4M3fB_Ygo9ZGRQJJ4wR38yyXOnPn3oJ2nQmb-3r-_5Jrp1dnZWrbvXAseOIzWRbdaMhRCBlz_TWKon11xDQFIh2SEReQugsKP6tLRQpNo23l-dAMREAU3RHc6isljYeKCJMTH8OtKmWDUIZRaJz3GteOLlOu9DS0JschstD17_Lzg9ZJ9B06F_JOS8Va1rDjLDV9gyzbDSvkr0VykSosY5LmfZ_QnYaUK5CuhJejqQcgulBQRGMFg4Fx8u51_-Xx542B5vl99_YUsioJ_FSKqJ7DvqBX3Qyk4-wm0s40FOdTeqyBL8B36WhzegsyYD80wdvVsnSWp9EMk6w7ubiARimkhV83OreXN7imSQc-6KSLYm1lTdbUl4_TD6or2bLdR6UuimeAkeim0X3Zh069GV_lo2XmxAX2zDOu1GLe1ISSC32J1LipqdLV54NsIm0dzFoPSJE5qPezebP-mJA9jy4o49zXLUOX3oy82wtVuaVU7l1KgHft0nZsuf20p-4XgGkc7AtluvaqdNdPAs0RwBUWKL9dMYecD0OdRud97e1v0LTENovjZYPAOwGpCWxOyA7Q1so0id7Pzr4fuXWGpHQAHiZfVXNwD7xnifwSNl6HKSW9_NyL7gNsPCHcyEjFaIa05bR76znY7rQjPUx12hli3EglCzfObw9nIjqBpvPaZj3G29fvtS6M7umsRBE1y7WMwQWkNGapIALi4zPLttHAppZCfCKdR206YC_Pz3uWjD_lacjqMvXuHhIiIOVYhS5RzB_oBAHUNPRgoBy05qiiinaaNxX1wcFZu_pmzcGPCMXC1cOvqZR_WujUDBoXVa0Hy23CtX1owyj6JopZ2bV67MYxnyKF2WGa5Gv32a4RBaEn8e4VXToR1WApZQlvbzcDtO5FBYQ-xasUhexNYq1sOLGauxK8MMu_S-Zpw2KvCXJ3fxlZtIo29cgKLHpZThYP7z7wMqG3h9evPGJSA1MTX3e2Vr9s0qPqoqCqfeSiBUEuv6n2llpyt6MHBf2fOTcq5eYku-hgnEcRosQqj3btdMJX5szrb8ngpLduA_8XrTjaQVX0q-FKKuEr5OicG5gtmLtVGHHYhdHBoWwxvo2ouGhvDQIpFocqQtvjZAbrgbt9FWEwYxY-ufCPhFIVY-YVrIJTIe6P4jHpIC3GLjXdnWqbQd9PEsNN-obmzJYlUJb2khoSV0KxswMcnV68S83kX4EWLJn3Blyww8lRGKA61TtRsMDDHhwHTYXp36It4oBgNidRhduoNvCNvSo7G4J2MyWQ8pv7d6HS6PDoeLenJcHRE3OfnvpsQbqw-urPp8HA4ORpNxxNvPBkfTyd9d-XORsPD0bHnjY6PT8dG7CHmpxCYxvDw9MQbTU8nE28yPvGGJwiAPJvPxZdp_oHad6VIg7BKEP39yOH58_P_FRS_ZQ)

## JWT Authentication

[![auth](https://mermaid.ink/img/pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ?type=png)](https://mermaid.live/edit#pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ)

## 🎫 Real-Time Event Ticketing System Checklist

- [x] **Accept User Prompts at Launch**
  Prompt users for configuration options before application startup.

- [x] **Error Handling and Input Validation**
  Ensure robust error handling and validation for all user inputs.

- [ ] **Start and Stop Functionality via CLI Buttons**
  Implement CLI commands to easily start and stop the system.

- [ ] **Default Configuration Feature**
  Provide a fallback configuration to use when custom settings are not specified.

- [ ] **Dynamic Configuration Feature (Optional)**
  Allow for real-time, customizable configurations during runtime.

- [ ] **Documentation for CLI Usage and Config Options**
  Provide clear documentation for all available CLI commands and configuration options.

- [ ] **Javadoc for All Classes and Methods**
  Ensure comprehensive Javadoc documentation is provided for maintainability.

  ## 🚀 Getting Started

  ### Prerequisites

  - Java 21 or higher
  - Maven 3.6.3 or higher
  - PostgreSQL 13 or higher

  ### Installation

  1. Clone the repository:

      ```shell
      git clone https://github.com/anuja-rahul/ticketingApp.git

      cd ticketingApp
      ```

  2. Configure the database in application.properties:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/ticketingapp
      spring.datasource.username=yourUsername
      spring.datasource.password=yourPassword
      ```

  3. Build the project:

      ```shell
      mvn clean install
      ```

  4. Run the application:

      ```shell
      mvn spring-boot:run
      ```

  ### Running Tests

  To run the tests, use the following command:

  ```shell
  mvn test
  ```

  ### Usage

  After starting the application, you can access the API at `http://localhost:8080/api`.

  ## 📄 License

  This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

