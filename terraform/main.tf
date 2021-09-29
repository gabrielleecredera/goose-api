locals {
  service_name = "goose"
}

module "api" {
  source = "./api"

  service_name        = "${var.environment}-${local.service_name}"
  dns_prefix          = "${var.environment}.${local.service_name}"
  cloud_dns_zone_name = "gcp-fowl-uk"
  region              = var.region
  image               = var.image
  image_tag           = var.image_tag

}
