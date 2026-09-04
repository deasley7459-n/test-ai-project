---
kind: external_dependency
name: Node.js / npm (Windows dev environment)
slug: nodejs
category: external_dependency
category_hints:
    - vendor_identity
scope:
    - '**'
---

### Node.js / npm
- Installed as the frontend toolchain for Vue development on this Windows machine via `winget`.
- The installer updates system PATH; terminals/IDEs must be restarted before `node` and `npm` are recognized.
- On Windows, `npm.ps1` is blocked by PowerShell's default Restricted execution policy; the standard fix is to set the user-level execution policy to `RemoteSigned`, which allows local scripts like `npm.ps1` while still requiring downloaded scripts to be signed.
- Default npm registry is `https://registry.npmjs.org/`; a China mirror (`https://registry.npmmirror.com`) can be configured via `npm config set registry` if downloads are slow.