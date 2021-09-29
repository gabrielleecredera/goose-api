data "google_container_registry_repository" "gcr" {
  region = "eu"
}

data "google_project" "project" {
}

data "google_dns_managed_zone" "zone" {
  name = var.cloud_dns_zone_name
}

locals {
  full_dns_name = "api.${var.dns_prefix}.${data.google_dns_managed_zone.zone.dns_name}"
}
