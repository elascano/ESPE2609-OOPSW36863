from model.picture_model import PictureModel
from view.picture_view import PictureView
from controller.picture_controller import PictureController

if __name__ == "__main__":
    model = PictureModel("pictures.json")
    view = PictureView()
    PictureController(model, view).run()
