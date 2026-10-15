# Product Backlog

# Requirements

# Functional Requirements

RF-01: The system shall allow registering, viewing, and updating customer information.

RF-02: The system shall allow registering, viewing, and updating equipment, including its name, category, and total inventory quantity.

RF-03: The system shall allow registering, viewing, and updating events, including event type, location, start date, and end date.

RF-04: The system shall allow creating, viewing, updating, and canceling reservations associated with a customer and an event.

RF-05: The system shall allow assigning equipment and quantities to each reservation.

RF-06: The system shall verify equipment availability for the requested reservation dates, considering existing reservations and equipment pending return, and prevent assignments that exceed availability.

RF-07: The system shall display events and their reservations in a calendar. The console version shall allow consulting them by date.

RF-08: The system shall allow recording equipment dispatches for each reservation, including the dispatch date and quantities delivered.

RF-09: The system shall allow recording full or partial equipment returns, including the quantities received and whether they are suitable for rental again.

RF-10: The system shall display an inventory summary showing total quantities, quantities reserved for the selected dates, quantities currently delivered and pending return, and quantities unavailable due to damage or maintenance.

# Non-Functional Requirements

RNF-01: The system shall preserve registered information and make it available after closing and reopening the program.

RNF-02: The system shall restrict access to authorized users through a login process.

RNF-03: The system shall use clear menus, labels, and messages in Spanish to help Eurotoldo staff perform their operations.

RNF-04: The system shall use consistent formats for dates, equipment names, and reservation statuses.

RNF-05: The system shall maintain non-negative integer quantities and prevent the same equipment allocation from being deducted twice when its status changes from reserved to delivered.

RNF-06: Inventory and reservation queries shall respond within two seconds with up to 1,000 equipment records and 5,000 reservations stored on the computer used for testing.
