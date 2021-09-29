terraform {
  backend "gcs" {
    bucket  = "terraform-state-gradscheme"
    prefix  = "terraform/state/goose"
  }
}
