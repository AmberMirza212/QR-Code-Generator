# WhatsApp-Inspired UI Redesign Plan

Redesign the QR Code Generator app to have a modern, clean, and recognizable UI inspired by WhatsApp's design language.

## User Review Required

> [!NOTE]
> The app will transition from a blue-themed gradient background to a clean, WhatsApp-inspired green and light gray theme. This includes a top app bar and redesigned buttons.

## Proposed Changes

### Theme & Colors

#### [MODIFY] [Color.kt](file:///C:/Users/DELL/AndroidStudioProjects/QRCodeGenerator/app/src/main/java/com/android/qrcodegenerator/ui/theme/Color.kt)
- Add WhatsApp colors:
    - `WhatsAppGreen`: `#075E54` (Dark Teal)
    - `WhatsAppLightGreen`: `#25D366` (Primary Green)
    - `WhatsAppGray`: `#F0F2F5` (Background Gray)
    - `WhatsAppSecondary`: `#128C7E` (Action Bar Color)

#### [MODIFY] [Theme.kt](file:///C:/Users/DELL/AndroidStudioProjects/QRCodeGenerator/app/src/main/java/com/android/qrcodegenerator/ui/theme/Theme.kt)
- Update `LightColors` to use WhatsApp Green as the primary color and WhatsApp Gray as the background.

### UI Components

#### [MODIFY] [QRGeneratorScreen.kt](file:///C:/Users/DELL/AndroidStudioProjects/QRCodeGenerator/app/src/main/java/com/android/qrcodegenerator/ui/QRGeneratorScreen.kt)
- Use `Scaffold` with a `CenterAlignedTopAppBar` (WhatsApp style).
- **Background:** Clean `WhatsAppGray` with **Sky Blue side gradients** to satisfy the "side per sky blue" request.
- **Top Bar:** Dark green background with white text.
- **Input Field:** Clean `OutlinedTextField` with rounded corners.
- **Generate Button:** Large, WhatsApp-green button with a "Generate" icon.
- **QR Card:** White background with a subtle border and shadow, similar to a chat bubble or media card.
- **Action Buttons:** Use WhatsApp-green for Save and Share buttons, possibly adding icons for better visual cues.

## Verification Plan

### Manual Verification
- Deploy the app and verify the new color scheme.
- Ensure the Top Bar is visible and styled correctly.
- Test QR generation to see if the new card and button styles look cohesive.
- Verify that the layout remains responsive on different screen sizes.
