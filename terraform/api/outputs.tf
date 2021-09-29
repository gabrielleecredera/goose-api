output "url" {
  value = replace("https://${local.full_dns_name}/", "/[.]\\/$/", "")
}
