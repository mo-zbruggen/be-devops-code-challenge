# Coding Challenge - Python Implementation


This application represents a RESTful service for Notes. It is built using the Flask web app framework.

A Note has 3 fields:
- `id`: a numerical ID to reference the note by
- `title`: the "display name" for the note
- `content`: the actual contents of the note

All of these endpoints are prefixed under the base `/notes` endpoint, and the routes list is provided below


| Endpoint          | Method | Route              | Status |
| ----------------- | ------ | ------------------ | ------ |
| Hello world!      | GET    | `/`                | ✅      |
| Get all notes     | GET    | `/notes/<note_id>` | ✅      |
| Get note by ID    | GET    | `/notes/`          | ✅      |
| Create note       | POST   | `/notes/`          | ✅      |
| Update note       | PUT    | `/notes/<note_id>` | ✅      |
| Delete all notes  | DELETE | TODO               | TODO   |
| Delete note by ID | DELETE | TODO               | TODO   |
