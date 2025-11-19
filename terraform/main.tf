provider "aws" {
  region = "us-east-1"
}

resource "aws_security_group" "sonarqube_sg" {
  name        = "sonarqube-sg"
  description = "Allow SSH, HTTP, HTTPS, and SonarQube UI access"
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # SSH for everyone, restrict in production!
  }
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 9000
    to_port     = 9000
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # SonarQube UI
  }
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "sonarqube" {
  ami                    = "ami-0ecb62995f68bb549" # Update if needed
  instance_type          = "t2.medium"
  key_name               = "sonarqube-key"         # Reference existing key
  vpc_security_group_ids = [aws_security_group.sonarqube_sg.id]
  user_data              = file("${path.module}/sonarqube-install.sh")
  tags = {
    Name = "SonarQube-Server"
  }
}

# S3 bucket for SonarQube reports (bucket name must be globally unique)
resource "aws_s3_bucket" "sonarqube_reports" {
  bucket = "sonarqube-reports-your-unique-id"
}

# Route53 DNS zone (replace sonarqube-example.com with a real domain you own/control)
resource "aws_route53_zone" "main" {
  name = "sonarqube-example.com"
}

# Route53 DNS record pointing to your EC2 public IP
resource "aws_route53_record" "sonarqube" {
  zone_id = aws_route53_zone.main.zone_id
  name    = "sonar.sonarqube-example.com"
  type    = "A"
  ttl     = 300
  records = [aws_instance.sonarqube.public_ip]
}
