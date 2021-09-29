resource "google_dns_record_set" "api" {
  name = local.full_dns_name
  type = "A"
  ttl  = 300

  managed_zone = data.google_dns_managed_zone.zone.name
  rrdatas      = [module.api_lb.external_ip]
}
