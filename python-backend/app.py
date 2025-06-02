from flask import Flask, jsonify, request, abort, redirect, url_for

app = Flask(__name__)


# In-memory notes DB
notes_db = []

sample_note = {
	"id": 1,
	"title": "Sample Note",
	"content": "Test start!"
}
notes_db.append(sample_note)

# Helper method to find a note within the DB, or return None if not found
def find_note(note_id):
	return next((note for note in notes_db if note["id"] == note_id), None)


@app.route("/")
def index():
	return redirect(url_for('get_notes'))

@app.route("/notes", methods=["GET"])
def get_notes():
	return notes_db

@app.route("/notes/<int:note_id>", methods=["GET"])
def get_note(note_id):
	note = find_note(note_id)
	if not note:
		abort(404, description="Note not found")
	return jsonify(note)

@app.route("/notes", methods=["POST"])
def create_note():

	if not request.json or "id" not in request.json:
		abort(400, description="Note must have an 'id'")

	note = {
		"id": request.json["id"],
		"title": request.json.get("title", ""),
		"content": request.json.get("content", ""),
	}

	notes_db.append(note)
	return jsonify(note), 201


@app.route("/notes/<int:note_id>", methods=["PUT"])
def update_note(note_id):
	note = find_note(note_id)

	if not note:
		abort(404, description="Note not found")

	data = request.json
	note["title"] = data.get("title", note["title"])
	note["content"] = data.get("content", note["content"])
	return jsonify(data)


#### TODO: Implement deletion by ID
# @app.route("/notes/<int:note_id>", methods=["DELETE"])
# def delete_note(note_id):
# 	...


#### TODO: Implement delete for all notes
# @app.route("/notes", methods=["DELETE"])
# def delete_notes():
# 	...


if __name__ == "__main__":
	app.run(debug=True, host='0.0.0.0', port=5000)