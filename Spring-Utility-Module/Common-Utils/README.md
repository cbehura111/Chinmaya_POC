# Common Utils Service Configuration

This document outlines the configuration properties used in the `common-util` application. Customize these properties based on your environment to control various features, such as logging, database connections, and more.

## Common Services

| **Property**              | **Description**                          | **Example Value**                           |
|---------------------------|------------------------------------------|---------------------------------------------|
| `commonservices.base.url` | Base URL for the common services         | `http://localhost:8585/commonservices/api/` |
| `networkCutOff.url`       | URL for fetching network cut-off details | `getNetworkCutOff`                          |

---

## External Service Configuration

| Name                                | Value                             | Description                                            |
|-------------------------------------|-----------------------------------|--------------------------------------------------------|
| `cbs.common.interFaceJSONDir`       | ../config/EXT_INTERFACES_v2       | Directory path for external interface JSON files       |
| `cbs.common.externalServiceURLPath` | ../config/ExternalServiceURL.json | Path to the JSON file containing external service URLs |                 


