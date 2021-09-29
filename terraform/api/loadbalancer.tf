# Extra credit: Normally using third party terraform modules is a bad idea, so why do you think we use this one?
module "api_lb" {
  source  = "GoogleCloudPlatform/lb-http/google//modules/serverless_negs"
  version = "~> 6.1"

  name    = "${var.service_name}-api"
  project = data.google_project.project.name

  managed_ssl_certificate_domains = [local.full_dns_name]
  ssl                             = true
  https_redirect                  = true

  backends = {
    default = {
      # List your serverless NEGs, VMs, or buckets as backends
      groups = [
        {
          group = google_compute_region_network_endpoint_group.api.id
        }
      ]

      enable_cdn = false

      log_config = {
        enable      = true
        sample_rate = 1.0
      }

      iap_config = {
        enable               = false
        oauth2_client_id     = null
        oauth2_client_secret = null
      }

      description             = null
      custom_request_headers  = null
      custom_response_headers = null
      security_policy         = null
    }
  }
}
