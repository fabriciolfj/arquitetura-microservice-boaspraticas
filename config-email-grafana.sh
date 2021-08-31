kubectl -n istio-system set env deployment/grafana GF_SMTP_ENABLED=true GF_SMTP_SKIP_VERIFY=true GF_SMTP_HOST=mail-server:25 GF_SMTP_FROM_ADDRESS=grafana@minikube.me
