## KtForm Autoscaling

Uses usage stas from [usage-reporter](../ktform-usage-reporter) and [usage-analytics](../ktform-usage-analytics) to perform cost-aware cluster autoscaling, and migrate workloads accordingly.

This essentially replaces [Karpenter]() and [Descheduler]() for Kubernetes, and provides similar experience for plain Docker containerized solutions (e.g. ECS Fargate).

## 📝 License

**ktform** is, and **forever will be**, licensed under the terms of the
[Mozilla Public License 2.0](../LICENSE).