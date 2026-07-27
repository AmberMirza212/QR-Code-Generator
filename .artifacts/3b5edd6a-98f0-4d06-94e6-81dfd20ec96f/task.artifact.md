# QR Code Generator Task List

- [ ] Setup dependencies and permissions
    - [ ] Add ZXing to `libs.versions.toml` and `build.gradle.kts`
    - [ ] Update `AndroidManifest.xml` (Permissions & FileProvider)
    - [ ] Create `res/xml/file_paths.xml`
- [ ] Implement Utility Layer
    - [ ] `QRCodeGenerator.kt` for bitmap generation
    - [ ] `FileUtils.kt` for saving/sharing logic
- [ ] Implement Presentation Layer
    - [ ] `QRCodeViewModel.kt` for state management
    - [ ] `QRGeneratorScreen.kt` for UI
- [ ] Finalize App
    - [ ] Update `MainActivity.kt`
- [ ] Verification
    - [ ] Build and sync project
    - [ ] Manual test plan
