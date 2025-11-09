
<p align="center">
  <img src="https://raw.githubusercontent.com/ktform/ktform/refs/heads/master/.idea/icon.png" alt="ktform logo" />
</p>

<p align="center">
  <em>KtForm <a href="https://www.linkedin.com/in/yuriy-yarosh-171ba3b9/"><b>by Yuriy Yarosh</b></a></em>
</p>

<hr />

<br/>

<div align="center">
  🚧 <img src="https://img.shields.io/badge/status-under_development-red?style=flat-square" alt="Status: Under Development" /> 🏗️
</div>

<br/>

## 🦋 Usage
~~[Run the app](USAGE.md) to set up and manage infrastructure.~~

**KTFORM IS IN EARLY DEVELOPMENT STAGES.**

## 🌋 Motivation

KtForm is an open-source, permissively licensed infrastructure management tool and a stable alternative to Terraform. 
It uses code generation to support multiple providers, simplifying maintenance and ensuring backward compatibility. 
Rather than supporting countless services, KtForm provides ready-to-use setups for common use cases (Generalized Reference Architecture), 
with a focus on self-managed Kubernetes and infrastructure drift detection.

KtForm
 - delivers a complete [solution catalog](./ktform-catalog) deployable across multiple [cloud providers](./ktform-controller), or locally via Docker, Rancher Desktop, Kind, or Minikube
 - provides built-in Infrastructure Drift detection, Drift Reporting, Cost-Aware Scheduling, and Automatic Cost Optimization
 - handles multi-cloud organizational structures while adhering to proven best practices and reference architectures
 - exposes all resources as a set of PostgreSQL database tables, that can be integrated with any existing PostgreSQL instances as Foreign Servers  

## 🛠️ Building

Run
*  `./gradlew run` to build and run the application.
*  `./gradlew build` to only build the application.
*  `./gradlew check` to run all checks, including tests.
*  `./gradlew clean` to clean all build outputs.

This project uses a version catalog ([`gradle/libs.versions.toml`](./gradle/libs.versions.toml)).

##  📜  [Governance Policy](./.github/GOVERNANCE.md)

By participating in the KtForm community or using the KtForm project in any way, you implicitly agree to the project's [Terms of Use](./.github/TERMS_OF_USE.md).

These terms include the unequivocal condemnation of state-sponsored terrorism, the rejection of authoritarianism, and support for the sovereignty of nations targeted by unlawful aggression. 
Failure to adhere to these principles will be considered a violation of the KtForm [Code of Conduct](./.github/CODE_OF_CONDUCT.md).

- [Terms of Use](./.github/TERMS_OF_USE.md)
- [KtForm Adopters](./.github/ADOPTERS.md)
- [KtForm Maintainers](./.github/MAINTAINERS.md)
- [KtForm Contributors](./.github/CONTRIBUTORS.md)
- [KtForm Reviewers](./.github/REVIEWERS.md)

## 📝 License

**KtForm** is, and **forever will be**, licensed under the terms of the
[Mozilla Public License 2.0](LICENSE).
