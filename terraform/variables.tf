
variable "region" {
  type    = string
  default = "europe-west2"
}

variable "environment" {
  type    = string
  default = "development"
}

variable "image" {
  type    = string
  default = "goose"
}

variable "image_tag" {
  type    = string
  default = "latest"
}
