# SonarQube + Python + Terraform Project

## Overview

This repository contains IaC with Terraform, Python application code, and a GitHub Actions workflow that analyzes code quality with SonarQube and Python security with Bandit.

- **SonarQube**: Ensures code quality, maintainability, and security for the whole codebase.
- **Bandit**: Performs Python-specific static security testing.
- **Terraform**: Manages and provisions cloud infrastructure (AWS).
- **CI/CD**: GitHub Actions automates analysis and report uploading.

---

## Folder Structure

.
├── .github/workflows/ # CI workflows (SonarQube, Bandit, etc.)
├── src/ # Python source code
│ └── main.py
├── terraform/ # Terraform code for cloud infrastructure
│ ├── main.tf
│ └── aws/ # (ignored by git, no secrets committed)
├── bandit_result.json # (Generated, gitignored) Bandit security scan (JSON)
├── bandit.txt # (Generated, gitignored) Bandit scan (text)
├── README.md # Project documentation
└── sonar-project.properties # SonarQube configuration


---

## Getting Started

### Prerequisites

- Python 3.x
- Terraform
- [Bandit](https://github.com/PyCQA/bandit/)
- SonarQube server access (self-hosted or SonarCloud)
- AWS CLI (for Terraform/backends)

### Run Code Quality and Security Analysis

#### 1. **SonarQube Analysis**
   - Ensure `.github/workflows/sonar-analysis.yml` exists and is configured.
   - Push your code to trigger the GitHub Actions pipeline:
     ```
     git push origin main
     ```
   - Review analysis in your SonarQube dashboard.

#### 2. **Local Bandit Scan**
   - Install Bandit if needed:
     ```
     pip install bandit
     ```
   - Run Bandit with JSON output:
     ```
     bandit -r src/ -f json > bandit_result.json
     ```
   - Or generate a text report:
     ```
     bandit -r src/ > bandit.txt
     ```

#### 3. **Terraform**
   - Move to the terraform directory and initialize/install:
     ```
     cd terraform
     terraform init
     terraform plan
     terraform apply
     ```

---

## Security & Best Practices

- **AWS credentials, secrets, and state files are excluded** by `.gitignore`. DO NOT commit them.
- **Bandit and SonarQube reports are ignored by git** (see `.gitignore`).
- **Never add sensitive files** (`*.pem`, keys, tfstate, Bandit output) to the repo.

---

## Contribution

Feel free to open issues or submit PRs!
1. Fork the repo and create a branch
2. Check your code with SonarQube and Bandit before submitting
3. Make sure you do not commit any sensitive or temporary files

---

## License

Specify your project license here (MIT, Apache 2.0, etc.)

---

## References

- [SonarQube Documentation](https://docs.sonarqube.org/)
- [Bandit Documentation](https://bandit.readthedocs.io/)
- [Terraform Documentation](https://www.terraform.io/)

---
