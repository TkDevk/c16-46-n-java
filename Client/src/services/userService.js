import axios from "axios";
// import { notifyError, notifySuccess } from "../utils/notifications";

const DB_URL = "http://localhost:8080/users";

/* export const findAll = async () => {
  try {
    return await axios.get(DB_URL);
  } catch (e) {
    console.error("Ops... we can't get users!");
  }

  return null;
}; */

export const save = async ({ username, email, password }) => {
  try {
    // must return an object

    return await axios.post(DB_URL, {
      username,
      email,
      password,
    });

  } catch (e) {
    throw e;
  }
};

export const update = async ({ username, email, id }) => {
  try {
    return await axios.put(`${DB_URL}/${id}`, {
      username,
      email,
    });
  } catch (e) {
    throw e;
  }
};

export const remove = async (id) => {
  try {
    // notifySuccess("User deleted");
    console.log("User deleted");
    await axios.delete(`${DB_URL}/${id}`);
  } catch (e) {
    throw e
  }
  return undefined;
};