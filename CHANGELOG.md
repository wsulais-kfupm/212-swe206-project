# Changelog

## 1.0.0 (2022-05-06)


### ⚠ BREAKING CHANGES

* Move REST endpoint to /api
* Use `Period` for `Candidate` experience
* Make `(lower|higher)Salary` properties
* Change `Candidate` to `Employee` in `Job`

### Features

* Add (G|S)etters for `Employee` ([a2e9667](https://github.com/wsulais-kfupm/212-swe206-project/commit/a2e9667c73223ca43a0812352a3fd85ba7b85dc3))
* Add `Employee` and `Interview` repositories ([8d7f888](https://github.com/wsulais-kfupm/212-swe206-project/commit/8d7f888e8b990075c6c34b71bb25910ac319ed46))
* Add `employee` field in `Candidate` ([b2fc3cd](https://github.com/wsulais-kfupm/212-swe206-project/commit/b2fc3cdc3d3793e77d3aea228f939f467d7ce761))
* Add `initJobOffers` to `LoadDatabase.java` ([83130ab](https://github.com/wsulais-kfupm/212-swe206-project/commit/83130abdffbca2b58c736ce494bafec4aea2960d))
* Add `Job(employee, jobOffer)` constructor ([4c26fa6](https://github.com/wsulais-kfupm/212-swe206-project/commit/4c26fa68084b0381f35c45ca2833f859de213e0f))
* Add `Job` constructors ([910de9f](https://github.com/wsulais-kfupm/212-swe206-project/commit/910de9f599bd497b3b4b7d2308b158566e4f8cdb))
* Add `toString` for `Benefit` ([6b8cc8b](https://github.com/wsulais-kfupm/212-swe206-project/commit/6b8cc8bc2a47cac1ab15b2e4f0e833dd4dccaf56))
* Add `toString` for `Interview` ([db5db6e](https://github.com/wsulais-kfupm/212-swe206-project/commit/db5db6e67b952609a8b9be38bf82f56b19839e26))
* Add `toString` for `Job` model class ([166e8fc](https://github.com/wsulais-kfupm/212-swe206-project/commit/166e8fc732e0c7d2cf44f54e15ce8630388a127c))
* Add `toString` to `JobOffer` ([5f2b351](https://github.com/wsulais-kfupm/212-swe206-project/commit/5f2b351079ef98eedce5b84fb3ef7d0e56ecd8dc))
* add baseSalary in JobPosition. ([2633fff](https://github.com/wsulais-kfupm/212-swe206-project/commit/2633fff8a6aff88fb1a3a695423c6c26ece60ff5))
* Add Data and repository classes ([123363d](https://github.com/wsulais-kfupm/212-swe206-project/commit/123363d0caad891dd72adcfd96eac394fa450553))
* Add JPA+Repositories for `JobOffer`&`Benefit` ([ab9fd3b](https://github.com/wsulais-kfupm/212-swe206-project/commit/ab9fd3b420b90c814c60db5f30eb8b9bcd67f321))
* Add unit title ([d0c9df6](https://github.com/wsulais-kfupm/212-swe206-project/commit/d0c9df6b06bf8f73fe660149ac52dda8a47037f0))
* calculate the salary in jobOffer. ([d778602](https://github.com/wsulais-kfupm/212-swe206-project/commit/d778602a080b6df3b00a1ed7957a1c6d41a17214))
* Expose Entity IDs in REST endpoints ([35cd6e7](https://github.com/wsulais-kfupm/212-swe206-project/commit/35cd6e7f20c17dac2fc7840ad357d48887d831c0))
* Initial commit ([b5be44d](https://github.com/wsulais-kfupm/212-swe206-project/commit/b5be44d7626ff9a7effbf2eb3106e52618dd4fc4))
* Initialize Database on start ([bd1ca22](https://github.com/wsulais-kfupm/212-swe206-project/commit/bd1ca224e53c98b9db7926e84f4a17f33f7b2f40))
* Persist H2 database to disk ([7e7d492](https://github.com/wsulais-kfupm/212-swe206-project/commit/7e7d492dfd9054a506d0d382891b6836b6ab5157))
* **test:** Initialize certain values in the db ([0ce3ea9](https://github.com/wsulais-kfupm/212-swe206-project/commit/0ce3ea9317da869e18d825626429a159dfbacfda))


### Bug Fixes

* `Candidate.setForename()` not working ([07b65d8](https://github.com/wsulais-kfupm/212-swe206-project/commit/07b65d806e07412547a14484d7df8c17c7b9c209))
* Add (G|S)etter for `Candidate` in `JobOffer` ([2416541](https://github.com/wsulais-kfupm/212-swe206-project/commit/24165417ec27647dadd9a43d01a53ffa9ee5874a))
* Add entity graphs for `JobBand` for eagerness ([4d5054c](https://github.com/wsulais-kfupm/212-swe206-project/commit/4d5054c34412559c43aff7c2b3f645b1e96e1aec))
* Add JPA annotations Part 1 ([a375589](https://github.com/wsulais-kfupm/212-swe206-project/commit/a37558919347b7ebfa9bb7475b99f83101cdc219))
* Change `Candidate` to `Employee` in `Job` ([32e128f](https://github.com/wsulais-kfupm/212-swe206-project/commit/32e128fc5e7cb52b28a79ec78e7a2500647c63d7))
* Change cascade type to merge ([0184415](https://github.com/wsulais-kfupm/212-swe206-project/commit/01844157929f02c380bfe9d41003de2f1d15f803))
* compile errors. ([8c91dad](https://github.com/wsulais-kfupm/212-swe206-project/commit/8c91daded8d24f20e7f2e35841106cb4a988d760))
* Enforce non-null columns ([7760cae](https://github.com/wsulais-kfupm/212-swe206-project/commit/7760caee6b2e60a6090ad22e1b7ffb2e69f26172))
* Exception in `JobOffer.setOfferedSalary` ([6113e98](https://github.com/wsulais-kfupm/212-swe206-project/commit/6113e98fd8c945ef63f14da0084a07c569f04b86))
* Typo in `Candidate`'s `yearsOfExperience` ([722eddb](https://github.com/wsulais-kfupm/212-swe206-project/commit/722eddb5a1f05f761971195bce10da2c05064f2c))


### Code Refactoring

* Make `(lower|higher)Salary` properties ([868e45f](https://github.com/wsulais-kfupm/212-swe206-project/commit/868e45f6707bec7cb408f565e48fa406632270a1))
* Use `Period` for `Candidate` experience ([8a3ac9f](https://github.com/wsulais-kfupm/212-swe206-project/commit/8a3ac9f03897db435daaad9ef685fd4efb6b199c))


### Miscellaneous Chores

* Move REST endpoint to /api ([d21ed1e](https://github.com/wsulais-kfupm/212-swe206-project/commit/d21ed1eababd049efa3daab7b0d495ead94aab2b))
