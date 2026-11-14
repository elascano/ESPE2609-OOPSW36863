from model.VideoProjector import VideoProjector
from model.ProjectManager import ProjectorManager
from model.ProjectionScreen import ProjectionScreen


print("=== VIDEO PROJECTOR ===")

brand = input("Enter brand: ")
model = input("Enter model: ")
brightness = int(input("Enter brightness: "))
is_on = input("Is it on? (yes/no): ").lower() == "yes"

projector = VideoProjector(brand, model, brightness, is_on)



print("\n=== PROJECTOR MANAGER ===")

manager_name = input("Enter manager name: ")
employee_id = int(input("Enter employee ID: "))
department = input("Enter department: ")

manager = ProjectorManager(manager_name, employee_id, department)

print("\n=== PROJECTION SCREEN ===")

width = float(input("Enter width: "))
height = float(input("Enter height: "))
material = input("Enter material: ")

screen = ProjectionScreen(width, height, material)


projector.save()
manager.save()
screen.save()

print("\nInformation saved successfully!")


projector.load()
manager.load()
screen.load()

print("Information loaded successfully!")


print("\n=== SAVED INFORMATION ===")

print("\nVideo Projector:")
print("Brand:", projector.brand)
print("Model:", projector.model)
print("Brightness:", projector.brightness)
print("Is On:", projector.is_on)

print("\nProjector Manager:")
print("Name:", manager.manager_name)
print("Employee ID:", manager.employee_id)
print("Department:", manager.department)

print("\nProjection Screen:")
print("Width:", screen.width)
print("Height:", screen.height)
print("Material:", screen.material)