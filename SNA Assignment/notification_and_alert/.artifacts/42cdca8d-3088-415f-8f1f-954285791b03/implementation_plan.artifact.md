# Add Attribution Text "(Divyasai 77)"

The user wants to add "(Divyasai 77)" to the application in a visible way. I will add this text as a footer in the main activity layout.

## User Review Required

> [!NOTE]
> The attribution text "(Divyasai 77)" will be added at the bottom of the main screen, below the "SHOW ALERT BOX" button.

## Proposed Changes

### App Resources

#### [MODIFY] [strings.xml](file:///D:/Hemant/d/2nd/app/src/main/res/values/strings.xml)
- Add a new string resource `attribution_text` with the value "(Divyasai 77)".

### Layouts

#### [MODIFY] [activity_main.xml](file:///D:/Hemant/d/2nd/app/src/main/res/layout/activity_main.xml)
- Add a `TextView` at the bottom of the `LinearLayout` to display the attribution text.
- Style the text to be centered and have some top margin for better spacing.

## Verification Plan

### Manual Verification
- Deploy the app to a device/emulator.
- Verify that the text "(Divyasai 77)" is visible on the main screen below the buttons.
